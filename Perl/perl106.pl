#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '^(.)*(\b(\d+(\.)?\d*)\b)(.)*$';
while(<>){
	print if /$regexp/;
}