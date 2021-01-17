#!/bin/sh

MAIN_CLASS=com.huize.phosphor.jarvis.server.JarvisApplication
#LANG="zh_CN"
JVM_ARGS="-server -Xmx600m -Xms600m -Xmn200m"

cd $(cd "$(dirname "$0")"; pwd)/../

##HOMES
LIB_HOME=$PWD/lib
LOG_HOME=$PWD/logs
CLASSPATH=$PWD


## files loading

for jar in $LIB_HOME/*.jar 
do	CLASSPATH=$CLASSPATH:$jar 
done 


export CLASSPATH 

start(){
	if [ -f "$LOG_HOME/server.pid" ] ; then
	echo "############ Application of '"$MAIN_CLASS"'  was running already!############" 
	else
	echo "############'"$MAIN_CLASS"' starting....############" 
	echo $CLASSPATH
	echo "############'"LOG_BACK"' starting....############" 
	echo $LOG_BACK
    nohup java $JVM_ARGS -cp $CONF_DIR:$CLASSPATH $MAIN_CLASS  > $LOG_HOME/console_`date '+%Y-%m-%d'`.log 2>&1 &
    echo $! > $LOG_HOME/server.pid
	echo "########### Application of '"$MAIN_CLASS"' started successful at:"`date '+%Y-%m-%d %T'`"############"
	sleep 1
	tail -f $LOG_HOME/console_`date '+%Y-%m-%d'`.log
	fi
}

stop(){
  if [ -f "$LOG_HOME/server.pid" ] ; then
  echo "############ Application of '"$MAIN_CLASS" stoping....############"	
  kill `cat $LOG_HOME/server.pid`
  sleep 1
  rm -rf $LOG_HOME/server.pid
  echo "########### Application of '"$MAIN_CLASS"' was stoped at:"`date '+%Y-%m-%d %T'`"############"
  else
   echo "########### Application of '"$MAIN_CLASS"' is not running. ############"
   exit 0;
   fi;
}

case $1 in
  start)
	start;
    ;;
  stop)
	stop;
    ;;
  restart)
	echo "############ Application of '"$MAIN_CLASS"' restarting....############"
    stop;
    sleep 1
    start;
    ;;
  *)
    echo "Usage: server.sh {start|stop|restart}" 
    ;;
esac
exit 0
