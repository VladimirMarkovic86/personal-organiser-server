# Personal organiser server

Personal organiser server project implements backend part of personal-organiser project, and is hosted on server-lib.

### Installing

Clone project from git by executing:

```
git clone git@github.com:VladimirMarkovic86/personal-organiser-server.git

or

git clone https://github.com/VladimirMarkovic86/personal-organiser-server.git
```

After that execute command:

```
cd personal-organiser-server
```

Add following line in hosts file:

```
127.0.0.1 personal-organiser
```

and run project with this command:

```
lein run
```

By default project listens on port 1601, so you can make requests on https://personal-organiser:1601 address.

**For purpose of making requests personal-organiser-client was made and you should start up personal-organiser-client also.**

## Authors

* **Vladimir Markovic** - [VladimirMarkovic86](https://github.com/VladimirMarkovic86)

## License

This project is licensed under the Eclipse Public License 1.0 - see the [LICENSE](LICENSE) file for details

