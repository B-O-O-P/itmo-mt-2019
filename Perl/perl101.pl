#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '^(.)*(cat)(.)*(cat)(.)*$';
while(<>){
	print if /$regexp/;
}