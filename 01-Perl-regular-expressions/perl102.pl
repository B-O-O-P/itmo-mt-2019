#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '^(.)*(\bcat\b)(.)*$';
while(<>){
	print if /$regexp/;
}