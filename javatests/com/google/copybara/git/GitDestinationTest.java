import com.google.copybara.ConfigValidationException;
import com.google.copybara.testing.DummyOriginalAuthor;
import com.google.copybara.testing.SkylarkTestExecutor;
import com.google.copybara.util.PathMatcherBuilder;
  private String url;
  private String fetch;
  private String push;

  private SkylarkTestExecutor skylark;
  public final ExpectedException thrown = ExpectedException.none();


    url = "file://" + repoGitDir;
    skylark = new SkylarkTestExecutor(options, GitModule.class);
    return new GitRepository(repoGitDir, /*workTree=*/null, /*verbose=*/true, System.getenv());
  public void errorIfUrlMissing() throws ConfigValidationException {
    skylark.evalFails(
        "git.destination(\n"
        + "    fetch = 'master',\n"
        + "    push = 'master',\n"
        + ")",
        "missing mandatory positional argument 'url'");
  }

  @Test
  public void errorIfFetchMissing() throws ConfigValidationException {
    skylark.evalFails(
        "git.destination(\n"
            + "    url = 'file:///foo',\n"
            + "    push = 'master',\n"
            + ")",
        "missing mandatory positional argument 'fetch'");
  }

  @Test
  public void errorIfPushMissing() throws ConfigValidationException {
    skylark.evalFails(
        "git.destination(\n"
            + "    url = 'file:///foo',\n"
            + "    fetch = 'master',\n"
            + ")",
        "missing mandatory positional argument 'push'");
    return evalDestination();
    return evalDestination();
  }

  private GitDestination evalDestination()
      throws ConfigValidationException {
    return skylark.eval("result",
        String.format("result = git.destination(\n"
            + "    url = '%s',\n"
            + "    fetch = '%s',\n"
            + "    push = '%s',\n"
            + ")", url, fetch, push));
    TransformResult result = TransformResults.of(workdir,
        originRef,
        new PathMatcherBuilder(
            excludedDestinationPaths, ImmutableList.<String>of()));
    fetch = "testPullFromRef";
    push = "testPushToRef";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "testPullFromRef";
    push = "testPushToRef";
    fetch = "pullFromBar";
    push = "pushToFoo";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
        .withOriginalAuthor(new DummyOriginalAuthor("Foo Bar", "foo@bar.com"))
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "master";
    fetch = "master";
    push = "refs_for_master";