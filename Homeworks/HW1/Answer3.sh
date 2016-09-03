awk '{for(w=1;w<=NF;w++) print $w}' < text1.txt | sort | uniq -c | sort -nr
