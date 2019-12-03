#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

while(<>){
    s/(\w)(\1)/$2/g;
	print;
}