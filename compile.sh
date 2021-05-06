#!/bin/bash
javac -d . ./src/*.java && jar -cvf JogoDaVelha.jar -C src/ .
