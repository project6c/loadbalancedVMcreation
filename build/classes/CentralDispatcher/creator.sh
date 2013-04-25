#!/bin/sh
#uname=$1
#memreq=$2
#cpureq=$3
echo "In CREATION MODULE"
echo $1
ssh $1 "sh request.sh $2 $3" >> command.txt


