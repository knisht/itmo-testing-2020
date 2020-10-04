module.exports = {
    pages: {
        'index': {
            entry: './src/pages/Home/main.js',
            template: 'public/index.html',
            title: 'Home',
            chunks: ['chunk-vendors', 'chunk-common', 'index']
        },
        'about': {
            entry: './src/pages/About/main.js',
            template: 'public/index.html',
            title: 'About',
            chunks: ['chunk-vendors', 'chunk-common', 'about']
        },
        'guess': {
            entry: './src/pages/Guess/main.js',
            template: 'pubic/index.html',
            title: 'Guess',
            chunks: ['chunk-vendors', 'chunk-common', 'guess']
        }
    }
}