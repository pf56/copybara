import com.google.copybara.authoring.Author;
import com.google.copybara.Change;
import com.google.copybara.ChangeVisitable.VisitResult;
import java.util.ArrayList;
import java.util.List;
    options.setForce(true);
    options.setForce(false);
        .matchesNext(MessageType.PROGRESS, "Git Destination: Checking out master")
        .matchesNext(MessageType.WARNING, "Git Destination: Cannot checkout 'FETCH_HEAD'."
            + " Ignoring baseline.")
    Glob firstGlob = new Glob(ImmutableList.of("foo/**", "bar/**"));
    Writer writer1 = destinationFirstCommit().newWriter(firstGlob);
    // Recreate the writer since a destinationFirstCommit writer never looks
    // for a previous ref.
    assertThat(destination().newWriter(firstGlob).getPreviousRef(ref1.getLabelName())).isEqualTo(
        ref1.asString());

  @Test
  public void testVisit() throws Exception {
    fetch = "master";
    push = "master";
    DummyReference ref1 = new DummyReference("origin_ref1");
    DummyReference ref2 = new DummyReference("origin_ref2");
    Files.write(workdir.resolve("test.txt"), "Visit me".getBytes());
    process(destinationFirstCommit().newWriter(destinationFiles), ref1);
    Files.write(workdir.resolve("test.txt"), "Visit me soon".getBytes());
    process(destination().newWriter(destinationFiles), ref2);

    final List<Change<?>> visited = new ArrayList<>();
    destination().newReader(destinationFiles).visitChanges(null,
        input -> {
          visited.add(input);
          return input.getLabels().get(DummyOrigin.LABEL_NAME).equals("origin_ref1")
              ? VisitResult.TERMINATE
              : VisitResult.CONTINUE;
        });
    assertThat(visited).hasSize(2);
    assertThat(visited.get(0).getLabels().get(DummyOrigin.LABEL_NAME)).isEqualTo("origin_ref2");
    assertThat(visited.get(1).getLabels().get(DummyOrigin.LABEL_NAME)).isEqualTo("origin_ref1");
  }