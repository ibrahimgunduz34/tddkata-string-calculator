# TDD Kata - String Calculator

[![Build Status](https://travis-ci.com/ibrahimgunduz34/tddkata-string-calculator.svg?branch=master)](https://travis-ci.com/ibrahimgunduz34/tddkata-string-calculator)


The implementation with tests regarding the following TDD challenge:
[https://osherove.com/tdd-kata-1](https://osherove.com/tdd-kata-1)

## Done:
* Task-1: Add two numbers, handle empty string.
* Task-2: Handle unknown amount of numbers in the input.
* Task-3 Add the comma separated values in multi-line input.
* Task-4 Allow to use custom delimiter or use the default one (,) if not exist.
* Task-5 Throw an exception if the input contains negative values. Exception message needs to contain all the negative numbers in the input.
* Task-6: Ignore the values that bigger than thousand.

## To-Do:
* Task-7 Delimiters can be of any length with the following format: 
```$xslt
format: “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
```

* Task-8 Allow multiple delimiters like this: 
```$xslt
“//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
```

* Task-9 make sure you can also handle multiple delimiters with length longer than one char



