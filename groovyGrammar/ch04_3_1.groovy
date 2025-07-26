schedule {
    daily {
        at '08:00', { println 'Good morning!' }
        at '22:00', { println 'Good night' }
    }

    weekly {
        on 'Monday', { println 'Start of the week!' }
    }
}