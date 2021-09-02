# jb4jsonld-issue

This repository contains maven projects to reproduce the issue reported at [https://github.com/kbss-cvut/jb4jsonld/issues/35](https://github.com/kbss-cvut/jb4jsonld/issues/35)

At first, build the ``testallpacked` project, which contains inside it the model sources. The test succeds.

```
> cd testallpacked
> mvn test
...
[INFO] Running org.opendatahacklab.jb4jsonldissue.DeserializeSubclassTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 1.583 s - in org.opendatahacklab.jb4jsonldissue.DeserializeSubclassTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  32.167 s
[INFO] Finished at: 2021-09-02T18:26:48+02:00
[INFO] ------------------------------------------------------------------------
```

Now, instead, build an artifact containing model classes
```
> cd ../model
> mvn install
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  5.923 s
[INFO] Finished at: 2021-09-02T18:28:56+02:00
[INFO] ------------------------------------------------------------------------
```
and use this artifact to build a project using model classes. The test will fail
```
> cd ../testseparated/
> mvn test
