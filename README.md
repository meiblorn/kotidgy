Kotidgy
===

Kotidgy aka "Kotlin Text Indexed Data Generator" 
is an index-based text data generator written in [Kotlin](http://kotlinlang.org).

Write **this**
```kotlin
templates {
      t { +"Hello" }
      t { +"Hi" / "Aloha" + ", man !" }
      t { +f { any { 2..100 } } + " apples " + "on the " + "plate" / "table" }
      t { +f { all { 2..3 } } + " apples " + "on the " + "plate" / "table" }
}
```
Get **that**
```text
Hello
Hi, man !
Aloha, man !
2 apples on the plate
3 apples on the plate
2 apples on the table
3 apples on the table
...
... skipped 194 other lines
...
100 apples on the table
100 apples on the table
23 apples on the plate
23 apples on the table
```

## Use it as a library

### Declare dependency

#### Maven

Add dependencies (you can also add other modules that you need):

```xml
<dependency>
    <groupId>com.meiblorn</groupId>
    <artifactId>kotidgy</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### Gradle

Add dependencies (you can also add other modules that you need):

```groovy
dependencies {
    implementation 'com:meiblorn:kotidgy:1.0.0'
}
```

Make sure that you have either `jcenter()` or `mavenCentral()` in the list of repositories:

```
repository {
    jcenter()
}
```

#### Gradle Kotlin DSL

Add dependencies (you can also add other modules that you need):

```groovy
dependencies {
    implementation("com.meiblorn:kotidgy:1.0.0")
}
```

Make sure that you have either `jcenter()` or `mavenCentral()` in the list of repositories.

### Write the code

Kotlin example:
```kotlin
val engine = KotidgyEngine()

val project = project {
  templates {
      t { +"Hello" }
      t { +"Hi" / "Aloha" }
      t { +f { 2..3 } + " apples" }
  }
}

val samples = engone.generate(project)
// Assert here is just for an illustration
assert(samples.toList() == listOf(
    Sample(IndexId(0), "Hello"),
    Sample(IndexId(0), "Hi"),
    Sample(IndexId(1), "Aloha"),
    Sample(
        IndexId(0),
        "2",
        Sample(IndexId(0), " apples")
    ),
    Sample(
        IndexId(1),
        "3",
        Sample(IndexId(0), " apples")
    )
))

for (sample in samples) {
    println(sample)
}
```

Output will be:
```bash
Hello
Hi
Aloha
2 apples
3 apples
```

## Use it as a script

- Provide jar directly:

```bash
java -jar <%path_to%>/kotidgy.jar <%path_to%>/examples/kotlin/script/index.kotidgy.kts
```

- Or use it via [kscript](https://github.com/holgerbrandl/kscript)
```bash
#!/usr/bin/env kscript

// Declare dependencies
@file:DependsOn("com.meiblorn:kotidgy:1.0.0")

import com.meiblorn.kotidgy.dsl.*

project {
    templates {
        t { +"hi" }
        t { +"hello" / "aloha" }
    }
}
``` 

## Why Kotlin ?
1) Kotlin is a [mature](https://en.wiktionary.org/wiki/mature) programming language
2) Kotlin is a type safe language
3) Kotlin has a native DSL builder support.
4) Writing a new own programming language is a very expensive operation both in time and effort.
5) Kotlin can do much more than own language and has less bugs.
6) It has an amazing huge community: Java + Kotlin
7) Kotlin can be used to write Bash scripts
8) Native IDE support and highlighting: [Intellij Idea](https://www.jetbrains.com/idea) (it is also available for Free)
 
## Contributing

You are welcome to contribute ! Just submit your PR and become a part of Boltun community!

Please read [contributing.md](contributing.md) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org) for versioning. For the versions available, see the [tags on this repository](https://github.com/meiblorn/boltun/tags). 

## Authors

* **Vadim Fedorenko** - [Meiblorn](https://github.com/meiblorn) -*Initial work*

See also the list of [authors](authors.md) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Your questions will appear here. Feel free to ask me.