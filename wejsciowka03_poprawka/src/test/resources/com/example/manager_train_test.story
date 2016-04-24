Given a trainmanager
When create train with name Kaszub with number 123 and add to trainmanager
Then size of trainmanager should be 1

When create train with name Slowiniec with number 345 and add to trainmanager
Then name of train in trainmanager should be Slowiniec

When delete train with name Slowiniec
Then only train with name Kaszub should remain in trainmanager and its size should be 1