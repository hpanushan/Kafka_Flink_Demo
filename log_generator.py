import time
import datetime
import pytz
import numpy
import random
import sys
from random import randrange
from tzlocal import get_localzone

local = get_localzone()
otime = datetime.datetime.now()
f = sys.stdout
timestr = time.strftime("%Y%m%d-%H%M%S")
verb=["CRS1","CRS2","CRS3","CRS4"] # server id 
logString = ""
# outFileName = 'access_log_'+timestr+'.log' # create file name

outFileName = 'demo.log'

def write_to_log(outFileName,logString): 
    logfile = open(outFileName,'a+')
    logfile.write(logString +'\n' )
    logfile.close()
    
    
    


# f.write('[%s %s] %s  %s  %s \n' % (dt,tz,vrb,cpu,mem))

    



try:
    while(True):
        time.sleep(1.8)
       
        
        vrb = numpy.random.choice(verb,p=[0.2,0.2,0.4,0.2]) # choices for server id 
        dt = otime.strftime('%d/%b/%Y:%H:%M:%S')
        tz = datetime.datetime.now(local).strftime('%z')
        temp = random.randint(50,90) # temprature random value
        cpu = random.randint(0,100) # cpu usage random value
        mem = random.randint(0,100) # memory random value
        f.write('%s %s %s  %s  %s  %s \n' % (dt,tz,vrb,temp,cpu,mem)) #std out put
        logString= "{} {} {} ".format(temp,cpu,mem) # string format for log file
        write_to_log(outFileName,logString) # execute log file
        
       
       

except KeyboardInterrupt:
	
	exit()     





        


