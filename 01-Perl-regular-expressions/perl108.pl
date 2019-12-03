#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '\([^)(]*(\b[^)(]*\b)[^)(]*\)';

while(<>){
	print if /$regexp/;
}