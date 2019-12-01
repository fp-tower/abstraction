![FP Abstraction Logo](logo/Foundation.png)<br>

[![Join the chat at https://gitter.im/fp-tower/foundation](https://badges.gitter.im/julien-truffaut/fp-foundation.svg)][gitter]
<span class="badge-patreon"><a href="https://www.patreon.com/bePatron?u=10482033" title="Donate to this project using Patreon"><img src="https://img.shields.io/badge/patreon-donate-yellow.svg" alt="Patreon donate button" /></a></span>

## Synopsis


### Module 1: [Typeclass](https://fp-tower.github.io/foundation/6-Typeclass.html#1)
* Different implementations of ad-hoc polymorphism
* Eq, Monoid
* Typeclass laws
* Instance uniqueness, location
* Typeclass hierarchy with Semigroup, CommutativeMonoid
* Use case with distributed computing (e.g. Spark)
* Higher kinded typeclass with Foldable
* Typeclass abuses

### Module 2: [Functors](https://fp-tower.github.io/foundation/7-Functors.html#1)
* Functor, Applicative, Monad, Traverse
* Combining effects
* Variance
* Typeclass coherence
* Typeclass granularity


## FAQ

### Where should I start?

Each module has:
* a set of slides (linked above) located at `docs/$module.html`
* a scala object containing all exercises located at `exercises/src/main/scala/exercises/$module/$moduleExercises.scala`
* a scala object containing all answers located at `exercises/src/main/scala/answers/$module/$moduleAnswers.scala`
* two test suites (one for exercises, one for answers) located at `exercises/src/test/scala/exercises/$module/$moduleTest.scala`

Start each module with the slides, at some point you will be prompted to work on some exercises. 
Do the exercises and check your answers are correct by running the tests for this module.
Finally, go back to the slides and repeat the process. If you have any question, please ask them on [gitter][gitter].

### How to run the tests?

```bash
sbt testExercises$X
```

For example tests for module 3 (Type) is run with:

```bash
sbt testExercises3
```

### Is this course free?

Yes, the material is open source and it uses a permissive licence [CC-BY-SA-4.0][licence].
However, the slides and exercises are currently made to be run by a trainer. Eventually, we aim to make this course
self-study with online videos but it is not likely to happen before mid 2020.

We do encourage people who enjoy the course to make a donation using [patreon][patreon].

[gitter]: https://gitter.im/fp-tower/foundation?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge
[licence]: https://creativecommons.org/licenses/by-sa/4.0/legalcode
[patreon]: https://www.patreon.com/bePatron?u=10482033