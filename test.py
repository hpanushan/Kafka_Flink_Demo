from pyflink.dataset import ExecutionEnvironment
from pyflink.datastream import StreamExecutionEnvironment
from pyflink.table import TableConfig, BatchTableEnvironment, DataTypes, StreamTableEnvironment
from pyflink.table.descriptors import Kafka, Json, FileSystem, Schema

exec_env = StreamExecutionEnvironment.get_execution_environment()

t_config = TableConfig()
t_env = StreamTableEnvironment.create(exec_env, t_config)

INPUT_TOPIC = 'xyz'
INPUT_TABLE = 'raw_message'
PROD_ZOOKEEPER = '...'
PROD_KAFKA = '...'

OUTPUT_TOPIC = 'summary_output'
OUTPUT_TABLE = 'feature_summary'
LOCAL_ZOOKEEPER = 'localhost:2181'
LOCAL_KAFKA = 'localhost:9092'


t_env.connect(
    Kafka()
    .version('universal')
    .topic(INPUT_TOPIC)
    .property("bootstrap.servers", PROD_KAFKA)

    .start_from_latest()
) \
.with_format(
    Json()
    .json_schema(
        "{"
        "  type: 'object',"
        "  properties: {"
        "    lon: {"
        "      type: 'number'"
        "    },"
        "    rideTime: {"
        "      type: 'string',"
        "      format: 'date-time'"
        "    }"
        "  }"
        "}"
    )
).register_table_source(INPUT_TABLE)

t_env.connect(Kafka()
    .version('universal')
    .topic(OUTPUT_TOPIC)
    .property("bootstrap.servers", LOCAL_KAFKA)

    .start_from_latest()
    ) \
    .with_format(
    Json()
    .json_schema(
       "{"
        "  type: 'object',"
        "  properties: {"
        "    lon: {"
        "      type: 'number'"
        "    },"
        "    rideTime: {"
        "      type: 'string',"
        "      format: 'date-time'"
        "    }"
        "  }"
        "}"
    )).register_table_sink(OUTPUT_TABLE)

t_env.from_path(INPUT_TABLE) \
    .insert_into(OUTPUT_TABLE)

t_env.execute('IU pyflink job')