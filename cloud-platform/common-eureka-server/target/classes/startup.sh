#!/bin/sh

# Source function library.
. /etc/init.d/functions
location="/home/precheck/commonEurekaServer"
pidname="com.asiainfo.eureka.server.EurekaServer"
export JAVA_HOME=/home/precheck/java/jdk1.8.0_151
export PATH=$JAVA_HOME/bin:$PATH
app_classpath="$location/lib/*:$location/classes/"
export CLASSPATH=$app_classpath:$CLASSPATH
if [ $# -ne 1 ]; then
	echo "Wrong input param..."
	echo "Usage: $0 start|stop|restart"
	exit 1
fi

start() {
        ps -ef | grep java | grep $location | grep $pidname >>/dev/null
        RETVAL=$?
        if [ $RETVAL = 0 ]; then
        echo -n "The $pidname Already Run:"
        [ $RETVAL != 0 ] && success || failure
        echo
        return 1
        fi
	nohup java -Dapp.home=$location -Xms1024m -Xmx1024m   $pidname > /dev/null 2> /dev/null &
	sleep 1
	echo -n "Starting $pidname Program:"
        RETVAL=$?
        [ $RETVAL = 0 ] && success || failure
        echo
}


stop() {
	echo -n $"Stopping $pidname: "
	ps -ef| grep java | grep $location |grep $pidname|awk '{print $2}'|while read pid
	do
		kill  $pid
	sleep 1
	done
	RETVAL=$?
	[ $RETVAL = 0 ] && success || failure
	echo
}

case "$1" in
	start)
        	start
		;;
	stop)
		stop
		;;
	status)
        	#status $pidname
        	#RETVAL=$?
        	ps -ef | grep java | grep $location | grep $pidname >>/dev/null
        	RETVAL=$?
        	if [ $RETVAL = 0 ]; then
        		echo -n "The $pidname is running"
        	else
        	    echo -n "The $pidname is stopped"
        	fi
        	echo
        	;;
	restart)
		stop
		start
		;;
	*)
		echo "Usage: $0 {start|stop|restart}"
		exit 1
		;;
esac

exit 0
