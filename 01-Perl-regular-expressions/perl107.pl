#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '^(.)*(\\\\)(.)*$';
while(<>){
	print if /$regexp/;
}