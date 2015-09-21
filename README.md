# bubbles

[![Build Status](https://travis-ci.org/RackSec/bubbles.svg?branch=master)](https://travis-ci.org/RackSec/bubbles)

> [after seeing Jimmy 'tie off' the his boat at the dock]
>
> * *Bubbles:* What the hell is that?
> * *McNulty:* Baltimore knot.
> * *Bubbles:* Baltimore knot? What the hell is a Baltimore knot?
> * *McNulty:* I dunno, but it's never the same thing twice.
>
> *"The Wire: Undertow (#2.5)" (2003)*

A ClojureScript in-browser SOAP client.

## Setup

To get an interactive development environment run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL.

## License

Copyright © 2015 Laurens Van Houtven

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
