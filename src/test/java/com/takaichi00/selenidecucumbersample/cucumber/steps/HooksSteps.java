package com.takaichi00.selenidecucumbersample.cucumber.steps;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import io.cucumber.java.ja.前提;
import java.util.List;
import java.util.Map;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

public class HooksSteps {

  @前提("以下の本を管理している")
  public void 以下の本を管理している(List<Map<String, String>> dataTable) {
    Operation operation = sequenceOf(
      deleteAllFrom("books"),
      insertInto("books").columns("id", "title").values(1, "title1").build());

    DriverManagerDestination destination = new DriverManagerDestination("jdbc:h2:tcp://localhost:9090/~/data/sample", "username", "password");

    DbSetup dbSetup = new DbSetup(destination, operation);
    dbSetup.launch();
  }
}
