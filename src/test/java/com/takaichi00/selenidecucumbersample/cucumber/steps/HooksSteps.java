package com.takaichi00.selenidecucumbersample.cucumber.steps;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.generator.ValueGenerators;
import com.ninja_squad.dbsetup.operation.Insert;
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

    Insert.Builder insetSql = insertInto("books")
      .withGeneratedValue("id", ValueGenerators.sequence().startingAt(1).incrementingBy(1))
      .columns("title");

    for (Map<String, String> row : dataTable) {
      insetSql.values(row.get("タイトル"));
    }

    Operation operation = sequenceOf(deleteAllFrom("books"), insetSql.build());

    DriverManagerDestination destination =
      new DriverManagerDestination("jdbc:h2:tcp://localhost:9090/~/data/sample",
                                  "username",
                               "password");

    DbSetup dbSetup = new DbSetup(destination, operation);
    dbSetup.launch();
  }
}
