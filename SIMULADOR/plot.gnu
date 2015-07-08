
set grid
set ytic 1
set xtic 2
set xlabel "Tempo"
set ylabel "Processo"
set key left top Left 

plot 'output.txt' using ($1):($3) w p t "Entrada",\
	'output.txt' using ($2):($3) w p t "Saida"


set term postscript landscape enhanced color dashed "Helvetica" 9 
set output "output.ps"
replot 
set term x11
quit	




