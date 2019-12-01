package toimpl.functors

import cats.data.NonEmptyList
import cats.effect.IO
import exercises.functors.FunctorsExercises.User
import exercises.functors._
import exercises.typeclass.{Monoid, Semigroup}

trait FunctorsToImpl extends FunctorsToImplLowLevel {

  def right[A, E](a: A): Either[E, A] = Right(a)
  def left[A, E](e: E): Either[E, A]  = Left(e)

  ////////////////////////
  // 1. Functor
  ////////////////////////

  implicit val listFunctor: Functor[List]
  implicit val optionFunctor: Functor[Option]
  implicit def eitherFunctor[E]: Functor[Either[E, ?]]
  implicit def validatedFunctor[E]: Functor[Validated[E, ?]]
  implicit def mapFunctor[K]: Functor[Map[K, ?]]
  implicit val idFunctor: Functor[Id]
  implicit def constFunctor[R]: Functor[Const[R, ?]]
  implicit def functionFunctor[R]: Functor[R => ?]
  implicit val predicateContravariantFunctor: ContravariantFunctor[Predicate]
  implicit val stringCodecInvariantFunctor: InvariantFunctor[StringCodec]
  implicit def composeFunctor[F[_]: Functor, G[_]: Functor]: Functor[Compose[F, G, ?]]

  ////////////////////////
  // 2. Applicative
  ////////////////////////

  implicit val listApplicative: Applicative[List]
  implicit val optionApplicative: Applicative[Option]
  implicit def eitherApplicative[E]: Applicative[Either[E, ?]]
  implicit def validatedApplicative[E: Semigroup]: Applicative[Validated[E, ?]]
  implicit def mapApply[K]: Apply[Map[K, ?]]
  implicit val idApplicative: Applicative[Id]
  implicit def constApplicative[R: Monoid]: Applicative[Const[R, ?]]
  implicit def functionApplicative[R]: Applicative[R => ?]

  implicit val zipListApply: Apply[ZipList]
  implicit def composeApplicative[F[_]: Applicative, G[_]: Applicative]: Applicative[Compose[F, G, ?]]

  ////////////////////////
  // 3. Monad
  ////////////////////////

  implicit val listMonad: Monad[List]
  implicit val optionMonad: Monad[Option]
  implicit def eitherMonad[E]: Monad[Either[E, ?]]
  implicit def mapFlatMap[K]: FlatMap[Map[K, ?]]
  implicit val idMonad: Monad[Id]
  implicit def functionMonad[R]: Monad[R => ?]

}

// trick to avoid implicit ambiguity because Monad and Traverse both extends Functor
trait FunctorsToImplLowLevel {

  ////////////////////////
  // 4. Traverse
  ////////////////////////

  implicit val listTraverse: Traverse[List]
  implicit val optionTraverse: Traverse[Option]
  implicit def eitherTraverse[E]: Traverse[Either[E, ?]]
  implicit def mapTraverse[K]: Traverse[Map[K, ?]]
  implicit val idTraverse: Traverse[Id]
  implicit def constTraverse[R]: Traverse[Const[R, ?]]

  def parseNumber(value: String): Option[BigInt]
  def checkAllUsersAdult(users: List[User]): Either[String, Unit]
  def checkAllUsersAdult_v2(users: List[User]): Either[NonEmptyList[String], Unit]
  def getUsers(names: List[String]): IO[List[User]]
  def getUsers_v2(names: List[String]): IO[Option[List[User]]]

  implicit def composeTraverse[F[_]: Traverse, G[_]: Traverse]: Traverse[Compose[F, G, ?]]
}
