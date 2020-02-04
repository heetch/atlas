# Introduction

This is a connector to Redshift source.
It gets metadata from Redshift, transform it to AtlasEntity and push it to Atlas.

# Getting Started

When Atlas is started (UI is available).

Add properties in atlas-bin/conf/atlas-application.properties
```
redshift.driver=com.amazon.redshift.jdbc42.Driver
redshift.url=jdbc:redshift://
redshift.username=
redshift.password=
```

Init Entity type :
```
atlas-bin/bin/init_redshift_type.sh
```

Import tables, columns from redshift

```
atlas-bin/bin/import-redshift.sh
```
