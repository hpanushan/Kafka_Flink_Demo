from pyflink.dataset import ExecutionEnvironment
from pyflink.datastream import StreamExecutionEnvironment
from pyflink.table import TableConfig, BatchTableEnvironment, DataTypes, StreamTableEnvironment
from pyflink.table.descriptors import Kafka

exec_env = StreamExecutionEnvironment.get_execution_environment()

t_config = TableConfig()
t_env = StreamTableEnvironment.create(exec_env, t_config)

# INPUT_TOPIC = 'test1'
# INPUT_TABLE = 'raw_message'
# PROD_ZOOKEEPER = 'node2:2181'
# PROD_KAFKA = 'node2:9092'

t_env.connect(Kafka().version('0.11').topic('test1'))

