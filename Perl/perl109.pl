#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '^(|\S|\S.*\S)$';

while(<>){
	print if /$regexp/;
}