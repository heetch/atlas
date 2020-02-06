# Search TypeDef by {typeName}
```
curl -u admin:admin -H 'Content-Type: application/json' -XGET http://localhost:21000/api/atlas/v2/types/typedef/name/${typeName}
```
# Get all TypeDef
```
curl -u admin:admin -H 'Content-Type: application/json' -XGET http://localhost:21000/api/atlas/v2/types/typedefs
```
# Create TypeDefs
```
curl -u admin:admin -H 'Content-Type: application/json' -XPOST http://localhost:21000/api/atlas/v2/types/typedefs -d '
{
  "enumDefs": [],
  "structDefs": [],
  "classificationDefs": [],
  "entityDefs": [
    {
      "category": "ENTITY",
      "name": "DB",
      "description": "DB",
      "typeVersion": "1.0",
      "attributeDefs": [
        {
          "name": "name",
          "typeName": "string",
          "isOptional": false,
          "cardinality": "SINGLE",
          "valuesMinCount": 1,
          "valuesMaxCount": 1,
          "isUnique": true,
          "isIndexable": true,
          "includeInNotification": false
        },
        {
          "name": "description",
          "typeName": "string",
          "isOptional": true,
          "cardinality": "SINGLE",
          "valuesMinCount": 0,
          "valuesMaxCount": 1,
          "isUnique": false,
          "isIndexable": false,
          "includeInNotification": false
        },
        {
          "name": "locationUri",
          "typeName": "string",
          "isOptional": true,
          "cardinality": "SINGLE",
          "valuesMinCount": 0,
          "valuesMaxCount": 1,
          "isUnique": false,
          "isIndexable": false,
          "includeInNotification": false
        },
        {
          "name": "owner",
          "typeName": "string",
          "isOptional": true,
          "cardinality": "SINGLE",
          "valuesMinCount": 0,
          "valuesMaxCount": 1,
          "isUnique": false,
          "isIndexable": false,
          "includeInNotification": false
        },
        {
          "name": "createTime",
          "typeName": "long",
          "isOptional": true,
          "cardinality": "SINGLE",
          "valuesMinCount": 0,
          "valuesMaxCount": 1,
          "isUnique": false,
          "isIndexable": false,
          "includeInNotification": false
        }
      ],
      "superTypes": [
        "DataSet"
      ]
    }
  ],
  "relationshipDefs": []
}
'
```

# Create Entity
```
curl -u admin:admin -H 'Content-Type: application/json' -XPOST http://localhost:21000/api/atlas/v2/entity -d '
{
  "entity": {
    "typeName": "DB",
    "attributes": {
      "owner": "John ETL",
      "createTime": 1581006357916,
      "qualifiedName": "Sales@cl1",
      "name": "Sales",
      "description": "sales database",
      "locationuri": "hdfs://host:8000/apps/warehouse/sales"
    },
    "guid": "-24094682036998",
    "provenanceType": 0,
    "version": 0,
    "classifications": [],
    "proxy": false
  }
}'
```
# Search Entity
```
curl -u admin:admin -H 'Content-Type: application/json' -XGET http://localhost:21000/api/atlas/v2/entity/uniqueAttribute/type/DB?attr:qualifiedName=Sales@cl1
```