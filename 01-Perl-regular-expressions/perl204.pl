#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';

while(<>){
    s/(\w+)([^\w]+)(\w+)/$3$2$1/;
	print;
}