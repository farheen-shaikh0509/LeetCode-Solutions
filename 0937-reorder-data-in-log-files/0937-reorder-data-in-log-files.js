/**
 * @param {string[]} logs
 * @return {string[]}
 */
var reorderLogFiles = function(logs) {
    const letterLogs = [];
    const digitLogs = [];

    for (const log of logs) {
        const firstSpaceIdx = log.indexOf(' ');
        const identifier = log.slice(0, firstSpaceIdx);
        const content = log.slice(firstSpaceIdx + 1);
        if (!isNaN(content[0]) && content[0] !== ' ') {
            digitLogs.push(log);
        } else {
            letterLogs.push({ log, identifier, content });
        }
    }
    letterLogs.sort((a, b) => {
        if (a.content !== b.content) {
            return a.content.localeCompare(b.content);
        }
        return a.identifier.localeCompare(b.identifier);
    });
    return [...letterLogs.map(item => item.log), ...digitLogs];
};