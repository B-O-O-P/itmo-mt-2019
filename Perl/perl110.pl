#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '\b(\w+)\1\b';

while(<>){
	print if /$regexp/;
}