/**

 * @param {Function} fn

 * @return {Function}

 */

var promisify = function(fn) {

    return function(...args) {

        return new Promise((resolve, reject) => {

            fn((result, error) => {

                if (error !== undefined) {

                    reject(error);

                } else {

                    resolve(result);

                }

            }, ...args);

        });

    };

};