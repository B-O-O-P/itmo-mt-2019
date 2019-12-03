#!/usr/bin/perl

my $doc = do {
    local $/ = undef;
    my $inputfile = 'input.txt';
    #open(my $input, '<:encoding(UTF-8)', $inputfile) or die("Could not open file '$inputfile' $!");
    <>
};

my @links = ();
my %set = ();
my @result = ();

while ($doc =~ m/<a((.)*?)href=["'](?<link>.*?)["']((.)*?)>/g) {
    push(@links, $+{link});
}

for $link (@links) {
    my $delims = "[/#?;:]";
    my $userInfo = "(.)*?(:.*?)?@";
    my $authDelim = "//";
    my $port = ":(\d+)";
    $link =~ m/($authDelim($userInfo)?(?<firstDomain>(.)*?)($delims|$))|(($userInfo)?(?<secondDomain>([^\/])*?)$port($delims|$))/g;

    if (length($+{firstDomain}) != 0) {
        $set{$+{firstDomain}} = 1;
    }

    if (length($+{secondDomain}) != 0) {
        $set{$+{secondDomain}} = 1;
    }
}

@result = sort keys(%set);
print "$_\n" for (@result);
