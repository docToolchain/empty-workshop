workspace {

    model {
        user = person "Kunde"
        softwareSystem = softwareSystem "Software System" {
            webapp = container "Web Application" {
                user -> this "Uses"
            }
            container "Database" {
                webapp -> this "Reads from and writes to"
            }
        }
    }

    views {
        systemContext softwareSystem {
            include *
           
        }

        container softwareSystem {
            include *
            //autolayout lr
        }

        theme default
    }

}