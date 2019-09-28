#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '^(.)*([xyz](.){5,17}[xyz])(.)*$';
while(<>){
	print if /$regexp/;
}