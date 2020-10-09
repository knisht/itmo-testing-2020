import {mount} from '@vue/test-utils'
import GuessingGame from "@/pages/Guess/GuessingGame";

describe('Guessing Game test', () => {
    test('Correct answer', () => {
        const wrapper = mount(GuessingGame, {
            propsData: {
                game: {sequence: [1, 2, 3], name: "Hello", link: "today", result: 4}
            }
        });

        expect(wrapper.find("#numbers").exists()).toBeTruthy()
        expect(wrapper.findAll("#numbers li")).toHaveLength(3)
        expect(wrapper.find("#correct_answer").exists()).toBeFalsy()
        expect(wrapper.find("#incorrect_answer").exists()).toBeFalsy()
    })
})
