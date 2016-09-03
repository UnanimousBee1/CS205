for i in *.txt;
do mv "$i" "$(echo "$i" | tr '[a-z]' '[A-Z]')";
done