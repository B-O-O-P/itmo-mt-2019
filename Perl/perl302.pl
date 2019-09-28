#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';
my $doc = do {
    local $/ = undef;
    #my $inputfile = 'input.txt';
    #open(my $input, '<:encoding(UTF-8)', $inputfile) or die("Could not open file '$inputfile' $!");
    <>
};

$doc =~ s/<[^>]*>//g;
$doc =~ s/^\s+//;
$doc =~ s/\s+$/\n/;
$doc =~ s/( )*\n( )*/\n/g;
$doc =~ s/( )+/ /g;
$doc =~ s/([\s]*\n){2,}/\n\n/g;
print($doc)