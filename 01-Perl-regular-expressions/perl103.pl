#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

my $regexp;
$regexp = '^(.)*(cat)(.)*$';
while(<>){
	print if ( /$regexp/i );
}