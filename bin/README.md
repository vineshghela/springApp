# SpringApp


# How to Run

First `fork` the repo and open the project in sprfing boot.

Next run the spring boot application.

# Please use PostMan to make requests.

## To make post request, go to postman and set a `Post` method.
Next go to `body`

Then select `raw`

Finally paste the following json string:

```json
{
    "name":"test3",
    "description":"something3"
}
```

Finally create a another postman request for a `GET` method and this will return all notes.

```url
http://localhost:9000/notes
```

### There are other URLS that you can use also

Method: `GET`
returns all notes

```url
http://localhost:9000/notes
```

Method: `POST`
Posts to the db and returns the newly inserted record.

```url
http://localhost:9000/notes
```

Method: `GET`
returns the note with the following ID.

```url
http://localhost:9000/notes/1
```

Method: `DELETE`
Deletes the record where the ID is specified.

```url
http://localhost:9000/notes/1
```
