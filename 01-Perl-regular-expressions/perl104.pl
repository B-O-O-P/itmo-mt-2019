#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '^(.)*(z(.){3}z)(.)*$';
while(<>){
	print if /$regexp/;
}