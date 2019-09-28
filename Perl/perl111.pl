#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '^(1(01*0)*1|0)*$';

while(<>){
	print if /$regexp/;
}