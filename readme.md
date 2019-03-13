#### Problems, Don't know if it's me or if is supposed to be that way?
- MariaDB Uses a `javax.swing.*`
- No `settings.gradle` Generated
- `build-native-image.sh` points to `my-problems-0.1-all.jar` but should be `my-problems-0.1.jar`
- Instead of a hard failure the `@Error` can cause an infinite loop
- `HttpResponse<T>` body returns an empty exception instead of the root cause
- Hibernate URL validator causing some really weird problems
- Logback reloadable config relies on some code that won't work with Graal