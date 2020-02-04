# Introduction

This is a connector to Redshift source.
It gets metadata from Redshift, transform it to AtlasEntity and push it to Atlas.

# Getting Started

When Atlas is started (UI is available).

Add env var
`You can skip this part if you ran the docker with theses envs
```
REDSHIFT_DRIVER=com.amazon.redshift.jdbc42.Driver
REDSHIFT_URL=jdbc:redshift://
REDSHIFT_USERNAME=
REDSHIFT_PASSWORD=
```

Init Entity type :
```
atlas-bin/bin/init_redshift_type.py
```

Import tables, columns from redshift

```
atlas-bin/bin/import-redshift.sh
```
