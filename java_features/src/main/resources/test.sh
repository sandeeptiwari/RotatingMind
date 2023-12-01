#!/usr/bin/bash

input_start=2022-11-01
input_end=2022-11-18

startDate=$(date -I -d "$input_start") || exit -1
endDate=$(date -I -d "$input_end") || exit -1
theDate="$startDate"

while [ "$theDate" != "$endDate" ];
do
  theDateShortYear=$(date -d "$theDate" +"%y-%m-%d")
  print "$theDateShortYear"
  for n in {0..23}
  do
    i=`(printf "%02d" $((n)))`; #i should go from 00..23
    j=`(printf "%02d" $((n + 1)))`; #j should go from 01..24
    myvar="$theDate $i:00:00";
    cat ../resources/test.text \
    | grep -i jolt-wlm \
    | grep -v ping | grep -v disco \
    | awk -v "myvar=$myvar" '{print myvar " " $8 " " $10 " " $4}' | sort | uniq -c \
    | awk '{print $2 "," $3 "," $4 "," $5 "," $1 "," $6}'
  done
  theDate=$(date -I -d "$theDate + 1 day")
  print "last -> $theDate"
done

