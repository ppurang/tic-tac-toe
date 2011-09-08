## Background

Mentoring java devs.

## Needed software

### Git

[Download and install git.](http://git-scm.com/download)

### Simple build tool

[Setup sbt](https://github.com/harrah/xsbt/wiki/Setup). This readme assumes that the sbt start script is named _sbt10_. Some commands that you can use are `test`, `compile`, and `run`.

## Clone this repo

To clone this repo and fetch all the branches invoke

   > git clone https://github.com/ppurang/tic-tac-toe

   > cd tic-tac-toe

   > git fetch

You should be on the master branch. Invoke the following to test that things are in order

   > sbt10 test

This makes sbt compile things and run all the tests. _Note:_ First attempt always takes a significant amount of time if this is the first invocation of sbt. It downloads scala libs, test libs etc.

An excellent time to have a break.

If you want to play around with sbt just invoke `sbt10` and you get a sbt console to play with.

## Branches and their significance

The following command shows you all the various branches

   > git branch -v

_Note:_ if you just see `master` and nothing else perhaps you forgot `git fetch`. The asterisk `*` indicates the present checked out branch.

To checkout a branch say SOMEBRANCH

   > git checkout SOMEBRANCH

and then you can rerun `sbt10` to see the effects of the changes in that branch.

More to come soon...