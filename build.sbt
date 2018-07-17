name := "grpc-address-book"

version := "0.1"

scalaVersion := "2.12.6"

import com.trueaccord.scalapb.compiler.Version.scalapbVersion
import com.trueaccord.scalapb.compiler.{Version => VersionPb}

PB.protoSources.in(Compile) := Seq(sourceDirectory.in(Compile).value / "proto");

PB.targets.in(Compile) := Seq(scalapb.gen() -> sourceManaged.in(Compile).value);

libraryDependencies ++= Seq(
  "com.trueaccord.scalapb" %% "scalapb-runtime" % scalapbVersion % "protobuf",
  "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % scalapbVersion,
  "com.datastax.cassandra" % "cassandra-driver-core" % "3.5.0",
  "com.datastax.cassandra" % "cassandra-driver-mapping" % "3.5.0",
  "io.grpc" % "grpc-netty" % VersionPb.grpcJavaVersion
);