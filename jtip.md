# Introduction #

`jtip` is a Java-based prototype implementation of the TIPP package schema.  It is intended for exploratory programming and testing in conjunction with development of the TIP schema.

`jtip` currently supports the TIPManifest 1.4 schema.

# Building jtip #

The source for `jtip` is located in the [tip/jtip](http://code.google.com/p/interoperability-now/source/browse/#svn%2Ftrunk%2Ftip%2Fjtip) directory.

`jtip` uses the [Maven](http://maven.apache.org/) build system.  You will need to [download and install](http://maven.apache.org/download.html) Maven in order to compile the code.  (You will also need Java 1.5 or later to compile and run the code.)

Once you have maven installed, you can run the following to compile the code, build the jtip JAR, and run unittests:
```
mvn package
```

The `jtip` JAR will be built in the `target` directory.

# Testing with `tipexplode` #
`tipexplode` is a simple sample program written using `jtip` that will open a TIP package, validate it, and write out the contents to a directory.  You can run it like this:
```
java -cp target/jtip-0.15-snapshot.jar com.globalsight.tip.samples.TIPExplode [tip-package] [target-directory]
```
There is also a linux wrapper for this in `bin/tipexplode`:
```
bin/tipexplode [tip-package] [target-directory]
```

# javadoc #
The situation is not great right now.  You can build it with Maven:
```
mvn javadoc:javadoc
```
Most things are undocumented; luckily, the API itself is very simple.