/**
 * @license
 * Copyright (c) 2014, 2021, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
/*
 * Your customer ViewModel code goes here
 */
define(['../accUtils', 'ojs/ojcore', 'knockout', 'jquery', 'ojs/ojinputtext', 'ojs/ojformlayout', 'ojs/ojlistview', 'ojs/ojlistitemlayout', 'ojs/ojknockout', 'ojs/ojknockout-model'],
        function (accUtils, oj, ko, $) {
            function CustomerViewModel() {
                // Below are a set of the ViewModel methods invoked by the oj-module component.
                // Please reference the oj-module jsDoc for additional information.

                /**
                 * Optional ViewModel method invoked after the View is inserted into the
                 * document DOM.  The application can put logic that requires the DOM being
                 * attached here.
                 * This method might be called multiple times - after the View is created
                 * and inserted into the DOM and after the View is reconnected
                 * after being disconnected.
                 */
                this.connected = () => {
                    accUtils.announce('Customers page loaded.', 'assertive');
                    document.title = "Customers";
                    // Implement further logic if needed
                };

                /**
                 * Optional ViewModel method invoked after the View is disconnected from the DOM.
                 */
                this.disconnected = () => {
                    // Implement if needed
                };

                /**
                 * Optional ViewModel method invoked after transition to the new View is complete.
                 * That includes any possible animation between the old and the new View.
                 */
                this.transitionCompleted = () => {
                    // Implement if needed
                };
                var rootViewModel = ko.dataFor(document.getElementById('globalBody'));
                self.userLogin = rootViewModel.userLogin;
                self.userGroups = rootViewModel.groupNames;
                self.userToken = rootViewModel.userToken;
                self.restResponse = ko.observable ("Klick the button to see for Yourself...");
                self.headerValue = 'Bearer '  + self.userToken._latestValue;
                self.buttonClick = function (event) {
                    $.ajax({
                        type: "GET",
                        //headers: rootViewModel.getHeaders().headers,
                        url: "http://127.0.0.1:8080/hello",
                        beforeSend: function (xhr) {
                            xhr.setRequestHeader('Authorization', headerValue);
                        },
                        success: function (res) {
                            self.restResponse (JSON.stringify(res));
                        },
                        failure: function (jqXHR, textStatus, errorThrown) {
                            self.restResponse (textStatus);
                        }
                    });
                    return true;
                }
            }

            /*
             * Returns an instance of the ViewModel providing one instance of the ViewModel. If needed,
             * return a constructor for the ViewModel so that the ViewModel is constructed
             * each time the view is displayed.
             */
            return CustomerViewModel;
        }
);
