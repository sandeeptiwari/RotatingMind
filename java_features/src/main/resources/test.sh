input_start=2022-06-12
input_end=2022-06-30

startDate=$(date -I -d "$input_start") || exit -1
endDate=$(date -I -d "$input_end") || exit -1
theDate="$startDate"

while [ "$theDate" != "$endDate" ]
do
  theDateShortYear=$(date -d "$theDate" +"%y-%m-%d")
  printf "%s\n" $theDateShortYear
  theDate=$(date -I -d "$theDate + 1 day")
done

